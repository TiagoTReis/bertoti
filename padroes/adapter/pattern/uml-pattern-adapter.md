```mermaid
classDiagram
    %% Target
    class SmartDevice {
        <<interface>>
        +turnOn()
        +turnOff()
        +isOn()
    }

    %% Adaptee (Sistema legado)
    class OldLamp {
        -boolean power
        +turnOn()
        +turnOff()
        +isPowered()
    }

    %% Adapter
    class OldLampAdapter {
        -OldLamp oldLamp
        +OldLampAdapter(OldLamp oldLamp)
        +turnOn()
        +turnOff()
        +isOn()
    }

    %% Client
    class SmartHomeSystem {
        +controlDevice(SmartDevice device)
    }

    %% Relacionamentos
    SmartDevice <|.. OldLampAdapter
    OldLampAdapter --> OldLamp : usa
    SmartHomeSystem --> SmartDevice : depende de
    ```
