import scala.io.Source
import java.io.PrintWriter

object ClubMembership {
  def main(args: Array[String]): Unit = {
    // 1. Load student-club data from CSV
    val filename = "student_data_extended.csv"
    val source = Source.fromFile(filename)
    val lines = source.getLines().drop(1).toList // Skip header
    source.close()
    
    // Parse CSV data
    val studentClubData = lines.map { line =>
      val cols = line.split(",")
      (cols(0), cols(1)) // (StudentID, Club)
    }
    
    // 2. Construct a bipartite graph
    println("Student-Club Bipartite Network:")
    println(s"Total edges: ${studentClubData.length}")
    
    // 3. Find most popular club
    val clubCounts = studentClubData.groupBy(_._2).mapValues(_.size)
    val mostPopularClub = clubCounts.maxBy(_._2)
    println(s"\nMost popular club: ${mostPopularClub._1} with ${mostPopularClub._2} members")
    
    // Find students in multiple clubs
    val studentClubCount = studentClubData.groupBy(_._1).mapValues(_.size)
    val studentsInMultipleClubs = studentClubCount.filter(_._2 > 1)
    println(s"\nStudents in multiple clubs: ${studentsInMultipleClubs.size}")
    studentsInMultipleClubs.toList.sortBy(-_._2).take(5).foreach { case (student, count) =>
      println(s"  Student $student: $count clubs")
    }
    
    // 4. Save the edge list for visualization
    val outputFile = "student_club_network.edgelist"
    val writer = new PrintWriter(outputFile)
    studentClubData.foreach { case (student, club) =>
      writer.println(s"$student $club")
    }
    writer.close()
    println(s"\nEdge list saved to: $outputFile")
  }
}
