error id: file:///C:/Users/HP/OneDrive/Documents/Scala_Project06/Scala_Practical06/q1.scala:[922..923) in Input.VirtualFile("file:///C:/Users/HP/OneDrive/Documents/Scala_Project06/Scala_Practical06/q1.scala", "object InventorySystem{
    case class Product(id: Int, name: String, quantity: Int, price: Double)

    val inventory1: Map[Int, Product] = Map(
        101 -> Product(101,"ProductA", 10, 25.00),
        102 -> Product(102,"ProductB", 5, 20.60),
        103 -> Product(103,"ProductC", 8, 10.00)
    )

    val inventory2: Map[Int, Product] = Map(
        102 -> Product(102,"ProductB", 10, 20.00),
        104 -> Product(104,"ProductD", 7, 40.25),
        105 -> Product(105,"ProductE", 12, 12.00)
    )

    def getProductNames(inventory: Map[Int, Product]): List[String] = {
        inventory.values.map(_.name).toList
    }

    def getTotalValue(inventory: Map[Int, Product]): Double = {
        inventory.values.map(product=>product.quantity*product.price).sum
    }

    def isInventoryEmpty(inventory: Map[Int, Product]): Boolean = {
        inventory.isEmpty
    }

    def 


    
}")
file:///C:/Users/HP/OneDrive/Documents/Scala_Project06/Scala_Practical06/q1.scala
file:///C:/Users/HP/OneDrive/Documents/Scala_Project06/Scala_Practical06/q1.scala:32: error: expected identifier; obtained rbrace
}
^
#### Short summary: 

expected identifier; obtained rbrace