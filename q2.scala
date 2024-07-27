import scala.io.StdIn._

object StudentRecords {

  // a. Function getStudentInfo
  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    println("Enter student's name:")
    val name = readLine().trim

    println("Enter student's marks:")
    val marks = readInt()

    println("Enter total possible marks:")
    val totalMarks = readInt()

    val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
    if (!isValid) {
      println(s"Error: ${errorMessage.getOrElse("Invalid input")}")
      getStudentInfoWithRetry()
    } else {
      val percentage = (marks.toDouble / totalMarks) * 100
      val grade = if (percentage >= 90) 'A'
                  else if (percentage >= 75) 'B'
                  else if (percentage >= 50) 'C'
                  else 'D'

      (name, marks, totalMarks, percentage, grade)
    }
  }

  // b. Function printStudentRecord
  def printStudentRecord(student: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = student
    println(s"Name: $name")
    println(s"Marks: $marks")
    println(s"Total Marks: $totalMarks")
    println(f"Percentage: $percentage%.2f")
    println(s"Grade: $grade")
  }

  // c. Function validateInput
  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty"))
    } else if (marks < 0) {
      (false, Some("Marks cannot be negative"))
    } else if (totalMarks <= 0) {
      (false, Some("Total possible marks must be greater than zero"))
    } else if (marks > totalMarks) {
      (false, Some("Marks cannot exceed total possible marks"))
    } else {
      (true, None)
    }
  }

  // d. Function getStudentInfoWithRetry
  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var isValid = false
    var studentInfo: (String, Int, Int, Double, Char) = ("", 0, 0, 0.0, 'D')

    while (!isValid) {
      println("Please enter student's information:")
      println("Name:")
      val name = readLine().trim

      println("Marks:")
      val marks = readInt()

      println("Total Possible Marks:")
      val totalMarks = readInt()

      val (valid, errorMessage) = validateInput(name, marks, totalMarks)
      if (!valid) {
        println(s"Error: ${errorMessage.getOrElse("Invalid input")}")
      } else {
        isValid = true
        val percentage = (marks.toDouble / totalMarks) * 100
        val grade = if (percentage >= 90) 'A'
                    else if (percentage >= 75) 'B'
                    else if (percentage >= 50) 'C'
                    else 'D'
        studentInfo = (name, marks, totalMarks, percentage, grade)
      }
    }

    studentInfo
  }

  def main(args: Array[String]): Unit = {
    val student = getStudentInfoWithRetry()
    printStudentRecord(student)
  }
}
