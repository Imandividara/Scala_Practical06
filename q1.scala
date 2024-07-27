object WarehouseInventory {
  def main(args: Array[String]): Unit = {
    
    val inventory1: Map[Int, (String, Int, Double)] = Map(
      101 -> ("ProductA", 10, 15.0),
      102 -> ("ProductB", 5, 25.0),
      103 -> ("ProductC", 20, 7.25)
    )

    val inventory2: Map[Int, (String, Int, Double)] = Map(
      102 -> ("ProductB", 7, 20.0),
      104 -> ("ProductD", 15, 30.0)
    )

    val productNames = getProductNames(inventory1)
    println(s"Product names in inventory1: $productNames")


    val totalValue = calculateTotalValue(inventory1)
    println(s"Total value of all products in inventory1: ${totalValue}")


    val isEmpty = isInventoryEmpty(inventory1)
    println(s"Is inventory1 empty? $isEmpty")


    val mergedInventory = mergeInventories(inventory1, inventory2)
    println(s"Merged Inventory: $mergedInventory")

    
    val productIdToCheck = 102
    checkAndPrintProductDetails(inventory1, productIdToCheck)
  }

  
  def getProductNames(inventory: Map[Int, (String, Int, Double)]): List[String] = {
    inventory.values.map(_._1).toList
  }

  
  def calculateTotalValue(inventory: Map[Int, (String, Int, Double)]): Double = {
    inventory.values.map { case (_, quantity, price) => quantity * price }.sum
  }

  
  def isInventoryEmpty(inventory: Map[Int, (String, Int, Double)]): Boolean = {
    inventory.isEmpty
  }


  def mergeInventories(
      inventory1: Map[Int, (String, Int, Double)],
      inventory2: Map[Int, (String, Int, Double)]
  ): Map[Int, (String, Int, Double)] = {
    inventory2.foldLeft(inventory1) { case (acc, (id, (name, quantity, price))) =>
      acc.get(id) match {
        case Some((_, existingQuantity, existingPrice)) =>
          acc + (id -> (name, existingQuantity + quantity, math.max(existingPrice, price)))
        case None =>
          acc + (id -> (name, quantity, price))
      }
    }
  }

  def checkAndPrintProductDetails(
      inventory: Map[Int, (String, Int, Double)],
      productId: Int
  ): Unit = {
    inventory.get(productId) match {
      case Some((name, quantity, price)) =>
        println(s"Product ID: $productId, Name: $name, Quantity: $quantity, Price: ${price}")
      case None =>
        println(s"Product with ID $productId does not exist in the inventory.")
    }
  }
}



