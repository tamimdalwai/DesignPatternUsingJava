# Singleton Design Pattern - README.md

## 🗒️ Notes

### Introduction
The Singleton Design Pattern is a creational pattern that ensures a class has only one instance and provides a global point of access to that instance. It is useful in scenarios where exactly one object is needed to coordinate actions across the system.

### Key Concepts
- **Single Instance**: Ensures that only one instance of the class is created.
- **Global Access Point**: Provides a way to access the instance globally.

### Benefits
- Controlled access to the sole instance.
- Reduces the need for creating multiple instances of the same object, saving memory.
- Can be used to manage shared resources like configuration settings, thread pools, etc.

### Implementation Approaches

1. **Eager Initialization**
   ```java
   public class Singleton {
       private static final Singleton INSTANCE = new Singleton();
       
       private Singleton() {}
       
       public static Singleton getInstance() {
           return INSTANCE;
       }
   }
   ```

2. **Lazy Initialization**
   ```java
   public class Singleton {
       private static Singleton instance;
       
       private Singleton() {}
       
       public static Singleton getInstance() {
           if (instance == null) {
               instance = new Singleton();
           }
           return instance;
       }
   }
   ```

3. **Thread-Safe Singleton (Double-Checked Locking)**
   ```java
   public class Singleton {
       private static volatile Singleton instance;
       
       private Singleton() {}
       
       public static Singleton getInstance() {
           if (instance == null) {
               synchronized (Singleton.class) {
                   if (instance == null) {
                       instance = new Singleton();
                   }
               }
           }
           return instance;
       }
   }
   ```

4. **Bill Pugh Singleton Design**
   ```java
   public class Singleton {
       private Singleton() {}
       
       private static class SingletonHelper {
           private static final Singleton INSTANCE = new Singleton();
       }
       
       public static Singleton getInstance() {
           return SingletonHelper.INSTANCE;
       }
   }
   ```

### Best Practices
- **Avoid Reflection**: Prevent breaking the singleton pattern by using reflection to instantiate another object.
- **Serialization**: Implement `readResolve` method to prevent another instance from being created during deserialization.
  ```java
  protected Object readResolve() {
      return getInstance();
  }
  ```

### Pitfalls
- **Global State**: Excessive use of singletons can introduce global state into an application, making it difficult to debug and test.
- **Hidden Dependencies**: Singleton can hide class dependencies, making code less clear and harder to maintain.

### Use Cases
- Configuration settings
- Logging
- Caching
- Thread pools
- Database connections

## 🌐 Sources
1. [medium.com - The Singleton Design Pattern: Best Practices and Pitfalls](https://medium.com/@shashidj206/the-singleton-design-pattern-best-practices-and-pitfalls-58f9d1c17ab7)
2. [digitalocean.com - Java Singleton Design Pattern Best Practices with Examples](https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples)
3. [digitalocean.com - Java Design Patterns - Example Tutorial](https://www.digitalocean.com/community/tutorials/java-design-patterns-example-tutorial)