package hello.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice); //최종 오더를 반환하기 위한 서비스
}
