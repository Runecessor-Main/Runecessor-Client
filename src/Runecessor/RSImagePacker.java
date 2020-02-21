package Runecessor;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RSImagePacker extends JFrame implements ListDataListener, ListSelectionListener, PropertyChangeListener, ItemListener {

    public static JFrame frame;
    public static JList list;
    public static DefaultListModel model;
    public static JScrollPane listPane;
    public static JTable table;
    public static JScrollPane tablePane;
    public static JRadioButton byName;
    public static JButton add = new JButton("Add");
    public static JButton remove = new JButton("Remove");
    public static JButton replace = new JButton("Replace");
    public static Image image;
    public static JLabel imageLabel;
    public static JButton dumpSprites;
    public int tableHeight;

    private static ExecutorService updateService = Executors.newFixedThreadPool(2);

    private static final String PATH_TO_INDEX_LOAD = ClientConstants.getSpritesLocation() + "sprites.idx";

    private static final String PATH_TO_DATA_LOAD = ClientConstants.getSpritesLocation() + "sprites.dat";

    private static final String PATH_TO_INDEX_SAVE = System.getProperty("user.home") + System.getProperty("file.separator") + ClientConstants.getSpritesLocation() + "sprites.idx";

    private static final String PATH_TO_DATA_SAVE = System.getProperty("user.home") + System.getProperty("file.separator") + ClientConstants.getSpritesLocation() + "sprites.dat";

	/* Keep commented out to keep obfuscated.
	public static void main(String[] args) {
	    new RSImagePacker();
	}
	*/

    public RSImagePacker() {
        try {
            UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel");
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception e2) {
            }
        }
        SpriteLoader.loadSprites(PATH_TO_INDEX_LOAD, PATH_TO_DATA_LOAD);

        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Sprite Packer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        buildInterface();
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setSize(550, 340);
        frame.setMinimumSize(frame.getSize());
        frame.setLocationRelativeTo(null);
    }

    public void buildInterface() {
        model = new DefaultListModel();
        model.addListDataListener(this);
        updateModel();
        list = new JList(model);
        list.addListSelectionListener(this);
        listPane = new JScrollPane(list);
        listPane.setBounds(5, 5, 120, 300);
        listPane.setVisible(true);
        frame.add(listPane);
        String fieldNames[] = {"Variable", "Value"};
        String dataValues[][] = {
                {"name", ""},
                {"drawOffsetX", ""},
                {"drawOffsetY", ""},
                {"width", ""},
                {"height", ""}
        };
        table = new JTable(dataValues, fieldNames);
        table.addPropertyChangeListener(this);
        table.setSelectionMode(0);
        table.setTransferHandler(null);
        tablePane = new JScrollPane(table);
        tableHeight = (table.getRowCount() * 19) + 19;
        tablePane.setBounds(130, 5, 300, tableHeight);
        tablePane.setVisible(true);
        drawButtons();
        frame.add(tablePane);
        frame.pack();
    }

    private void updateModel() {
        model.clear();
        for (int index = 0; index < SpriteLoader.cache.length; index++) {
            model.addElement(index);
        }
    }

    public void drawButtons() {
        JButton button = new JButton("Write Cache");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported at the moment.");
            }
        });
        button.setBounds(435, 5, 100, 22);
        frame.add(button);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();

                chooser.showOpenDialog(null);

                final File file = chooser.getSelectedFile();

                if (file == null || (!file.getAbsolutePath().toLowerCase().contains("png") &&
                        !file.getAbsolutePath().toLowerCase().contains("jpg") && !file.getAbsolutePath().toLowerCase().contains("jpeg"))) {
                    JOptionPane.showMessageDialog(null, "This file cannot be supported.");
                    return;
                }
                try {
                    Future<Boolean> futureAdd = updateService.submit(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                SpriteLoader.add(new SpriteLoader(Files.readAllBytes(file.toPath())));
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }, true);

                    while (!futureAdd.isDone()) {
                        Thread.sleep(500L);
                    }

                    updateModel();
                    list.repaint();
                    listPane.repaint();

                    Future<Boolean> futureWrite = updateService.submit(new Runnable() {
                        @Override
                        public void run() {
                            SpriteLoader.writeSprites(PATH_TO_INDEX_SAVE, PATH_TO_DATA_SAVE);
                        }
                    }, true);

                    while (!futureWrite.isDone()) {
                        Thread.sleep(500L);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add.setBounds(435, 30, 100, 22);
        frame.add(add);

        replace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();

                if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(null, "You must first select an entry to replace on the left.");
                    return;
                }
                JFileChooser chooser = new JFileChooser();

                chooser.showOpenDialog(null);

                File file = chooser.getSelectedFile();

                if (file == null || (!file.getAbsolutePath().toLowerCase().contains("png") &&
                        !file.getAbsolutePath().toLowerCase().contains("jpg") && !file.getAbsolutePath().toLowerCase().contains("jpeg"))) {
                    JOptionPane.showMessageDialog(null, "This file cannot be supported.");
                    return;
                }
                try {
                    boolean highDefinition = JOptionPane.showConfirmDialog(null, "Does this image support alpha channels?") == 0;

//                    RSImageLoader.replace(selectedIndex, Files.readAllBytes(file.toPath()), highDefinition);
//                    updateModel();
//                    list.repaint();
//                    listPane.repaint();
                    throw new UnsupportedOperationException("Not supported at the moment.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        replace.setBounds(435, 60, 100, 22);
        frame.add(replace);

    }

    public void updateProperties(int index) {
        if (SpriteLoader.cache[index] != null) {
            if (imageLabel != null) {
                frame.remove(imageLabel);
            }
            try (ByteArrayInputStream inputStream = new ByteArrayInputStream(SpriteLoader.cache[index].spriteData)) {
                image = ImageIO.read(inputStream);
            } catch (IOException ioe) {
                throw new RuntimeException("Could not create image.");
            }
            imageLabel = new JLabel(new ImageIcon(image));
            imageLabel.setBounds(130, tableHeight + 10, image.getWidth(null), image.getHeight(null));
            frame.setSize((140 + image.getWidth(null)) > 550 ? (140 + image.getWidth(null)) : 550, (tableHeight + 50) +
                    image.getHeight(null) > 340 ? (tableHeight + 45) + image.getHeight(null) : 340);
            frame.add(imageLabel);
            frame.repaint();
        } else {
            frame.remove(imageLabel);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent arg0) {
    }

    @Override
    public void valueChanged(ListSelectionEvent arg0) {
        int index = 0;
        if (list.getSelectedIndex() != -1) {
            SpriteLoader sprite = SpriteLoader.cache[list.getSelectedIndex()];

            if (sprite != null) {
                table.setValueAt(sprite.name, index++, 1);
                table.setValueAt(Integer.toString(sprite.drawOffsetX), index++, 1);
                table.setValueAt(Integer.toString(sprite.drawOffsetY), index++, 1);
                table.setValueAt("width", index++, 1);
                table.setValueAt("height", index, 1);
            }
            updateProperties(list.getSelectedIndex());
        }
    }

    @Override
    public void contentsChanged(ListDataEvent arg0) {
    }

    @Override
    public void intervalAdded(ListDataEvent arg0) {
    }

    @Override
    public void intervalRemoved(ListDataEvent arg0) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
