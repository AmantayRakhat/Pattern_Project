package project.pattern_project;

interface UpdateStrategy {
    void update(CartElementController controller, int quantity);
}

 class IncrementalUpdateStrategy implements UpdateStrategy {
    @Override
    public void update(CartElementController controller, int quantity) {
        controller.update(quantity);
    }
}

 class DecrementalUpdateStrategy implements UpdateStrategy {
    @Override
    public void update(CartElementController controller, int quantity) {
        if (quantity > 0) {
            controller.update(quantity);
        }
    }


}

