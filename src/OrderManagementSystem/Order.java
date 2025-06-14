package OrderManagementSystem;

import java.util.Map;

public class Order {
    User user;
    Address deliveryAddress;
    Map<Integer, Integer> productAndCountMap;
    Warehouse warehouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;

    Order(User user, Warehouse warehouse){
        this.user = user;
        this.productAndCountMap = user.getUserCart().getCartItems();
        this.warehouse = warehouse;
        this.deliveryAddress = user.address;
        invoice = new Invoice();
        invoice.generateInvoice(this);
    }

    public void checkout(){

        //1. update inventory
        warehouse.removeItemFromInventory(productAndCountMap);

        //2. make Payment
        boolean isPaymentSuccess = makePayment(new UPIPaymentMode());

        //3. make cart empty
        if(isPaymentSuccess) {
            user.getUserCart().emptyCart();
        }
        else{
            warehouse.addItemToInventory(productAndCountMap);
        }
    }

    public boolean makePayment(PaymentMode paymentMode){
        payment = new Payment(paymentMode);
        return payment.makePayment();
    }

    public void generateOrderInvoice(){
        invoice.generateInvoice(this);
    }
}
