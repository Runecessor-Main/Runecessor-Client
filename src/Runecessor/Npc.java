package Runecessor;

public final class Npc extends Entity {

    public EntityDefinition desc;

    Npc() {
    }

    private Model getBuiltModel() {
        if (super.anim >= 0 && super.sequenceDelayCycle == 0) {
            Sequences animation = Sequences.anims[super.anim];
            int currentFrame = animation.primary[super.sequenceFrame];
            if (super.nextAnimationFrame > animation.primary.length - 1) {
                super.nextAnimationFrame = animation.primary.length - 1;
            }
            int nextFrame = animation.primary[super.nextAnimationFrame];
            int cycle1 = animation.duration[super.sequenceFrame];
            int cycle2 = super.sequenceCycle;

            int i1 = -1;
            if (super.moveSequence >= 0 && super.moveSequence != super.standAnimation)
                i1 = Sequences.anims[super.moveSequence].primary[super.moveSequenceFrame];
            return desc.method164(i1, currentFrame, Sequences.anims[super.anim].vertices, nextFrame, cycle1, cycle2);
        }
        int currentFrame = -1;
        int nextFrame = -1;
        int cycle1 = 0;
        int cycle2 = 0;
        if (super.moveSequence >= 0) {
            Sequences animation = Sequences.anims[super.moveSequence];
            currentFrame = animation.primary[super.moveSequenceFrame];
            nextFrame = animation.primary[super.nextIdleAnimationFrame];
            cycle1 = animation.duration[super.moveSequenceFrame];
            cycle2 = super.moveSequenceCycle;
        }
        return desc.method164(-1, currentFrame, null, nextFrame, cycle1, cycle2);
    }

    public Model getRotatedModel() {
        if (desc == null)
            return null;
        Model model = getBuiltModel();
        if (model == null)
            return null;
        super.height = model.modelHeight;
        if (super.spotanim != -1 && super.spotanimFrame != -1) {
            SpotAnim spotAnim = SpotAnim.cache[super.spotanim];
            Model model_1 = spotAnim.getModel();
            if (model_1 != null) {
                int j = spotAnim.animationSequence.primary[super.spotanimFrame];
                int nextFrame = spotAnim.animationSequence.primary[super.nextGraphicsAnimationFrame];
                int cycle1 = spotAnim.animationSequence.duration[super.spotanimFrame];
                int cycle2 = super.spotanimCycle;
                Model model_2 = new Model(true, Frames.isNegativeZero(j), false, model_1);
                model_2.method475(0, -super.spotanimY, 0);
                model_2.method469();
                model_2.method470(j, nextFrame, cycle1, cycle2);
                model_2.anIntArrayArray1658 = null;
                model_2.anIntArrayArray1657 = null;
                if (spotAnim.scale != 128 || spotAnim.height != 128)
                    model_2.scaleModel(spotAnim.scale, spotAnim.scale, spotAnim.height);
                model_2.method479(64 + spotAnim.ambient, 850 + spotAnim.contrast, -30, -50, -30, true);
                Model aModel[] =
                        {model, model_2};
                model = new Model(aModel);
            }
        }
        if (desc.size == 1)
            model.aBoolean1659 = true;
        return model;
    }

    public boolean isVisible() {
        return desc != null;
    }
}
