# Checkout Service - SOLID Example

Este projeto implementa um sistema de checkout seguindo os princípios **SOLID** de forma prática. A ideia é simples: cada classe faz apenas uma coisa (SRP), o serviço de checkout não precisa mudar quando adicionamos novas formas de pagamento (OCP),
e qualquer implementação de pagamento funciona sem quebrar nada (LSP). As interfaces são pequenas e específicas (ISP), e o `CheckoutService` depende de abstrações como `OrderRepository` e `Notifier`, não de classes concretas (DIP). Assim, podemos 
trocar o método de pagamento, a forma de persistência ou o tipo de notificação sem alterar o serviço central. No projeto, o cálculo de total de pedidos fica no `PricingService`, os pagamentos são tratados via Strategy Pattern com classes como `PixPayment` e 
`CreditCardPayment`, a persistência é desacoplada via `Database` com `OrderRepository`, e as notificações são enviadas pelo `EmailSender`. Esse design garante código limpo, fácil de manter e extensível.

### ADRs (Architecture Decision Records)

**Strategy para pagamentos:** adotamos o Strategy Pattern para lidar com os métodos de pagamento, permitindo adicionar novas opções sem modificar o `CheckoutService`, atendendo ao OCP.

**Repository e Notifier desacoplados:** optamos por interfaces separadas para persistência e notificação, garantindo que o `CheckoutService` dependa apenas de abstrações e que cada interface tenha responsabilidade única, seguindo DIP e ISP.
