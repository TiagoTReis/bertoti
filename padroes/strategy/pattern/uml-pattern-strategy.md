```mermaid
classDiagram
    class DeliveryStrategy {
        <<interface>>
        +deliver(String packageName)
    }

    class BikeDelivery {
        +deliver(String packageName)
    }

    class TruckDelivery {
        +deliver(String packageName)
    }

    class DeliveryService {
        -DeliveryStrategy strategy
        +setStrategy(DeliveryStrategy strategy)
        +deliverPackage(String packageName)
    }

    class StrategyPatternDemo {
        +main(String[] args)
    }

    DeliveryStrategy <|.. BikeDelivery
    DeliveryStrategy <|.. TruckDelivery
    DeliveryService --> DeliveryStrategy
    StrategyPatternDemo --> DeliveryService
```
