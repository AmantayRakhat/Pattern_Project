package project.pattern_project;

interface DeliveryStrategy {
    String deliverOrder(int userId, String address);
}

interface TotalCalculationStrategy {
    int calculateTotal(int quantity, int price);
}
 class HomeDeliveryStrategy implements DeliveryStrategy {
    @Override
    public String deliverOrder(int userId, String address) {
        return ("Ваш заказ доставлен в адрес: " + address);
    }
}

 class PostamatDeliveryStrategy implements DeliveryStrategy {
    @Override
    public String deliverOrder(int userId, String address) {
        return ("Ваш заказ доставлен в Каспи Постамат");
    }
}

 class SimpleTotalCalculationStrategy implements TotalCalculationStrategy {
    @Override
    public int calculateTotal(int quantity, int price) {
        return quantity * price;
    }
}

 class DiscountedTotalCalculationStrategy implements TotalCalculationStrategy {
    private static final double DISCOUNT_PERCENTAGE = 0.9; // 10% discount

    @Override
    public int calculateTotal(int quantity, int price) {
        int discountedPrice = (int) (price * DISCOUNT_PERCENTAGE);
        return quantity * discountedPrice;
    }
}
