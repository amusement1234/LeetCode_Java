
// public class Serialization {
//   public String serialize(Object object) {
//     String serializedResult = ...;
//     //...
//     return serializedResult;
//   }
  
//   public Object deserialize(String str) {
//     Object deserializedResult = ...;
//     //...
//     return deserializedResult;
//   }
// }


// public class Serializer {
//   public String serialize(Object object) {
//     String serializedResult = ...;
//     ...
//     return serializedResult;
//   }
// }

// public class Deserializer {
//   public Object deserialize(String str) {
//     Object deserializedResult = ...;
//     ...
//     return deserializedResult;
//   }
// }


// public interface Serializable {
//   String serialize(Object object);
// }

// public interface Deserializable {
//   Object deserialize(String text);
// }

// public class Serialization implements Serializable, Deserializable {
//   @Override
//   public String serialize(Object object) {
//     String serializedResult = ...;
//     ...
//     return serializedResult;
//   }
  
//   @Override
//   public Object deserialize(String str) {
//     Object deserializedResult = ...;
//     ...
//     return deserializedResult;
//   }
// }

// public class DemoClass_1 {
//   private Serializable serializer;
  
//   public Demo(Serializable serializer) {
//     this.serializer = serializer;
//   }
//   //...
// }

// public class DemoClass_2 {
//   private Deserializable deserializer;
  
//   public Demo(Deserializable deserializer) {
//     this.deserializer = deserializer;
//   }
//   //...
// }


// public class Serializer { // 参看JSON的接口定义
//   public String serialize(Object object) { //... }
//   public String serializeMap(Map map) { //... }
//   public String serializeList(List list) { //... }
  
//   public Object deserialize(String objectString) { //... }
//   public Map deserializeMap(String mapString) { //... }
//   public List deserializeList(String listString) { //... }
// }