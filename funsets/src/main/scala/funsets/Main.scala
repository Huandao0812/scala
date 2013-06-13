package funsets

object Main extends App {
  import FunSets._
  def A(x: Int): Boolean =  if( 0<= x && x <= 5) true else false
  def C = map(A,x => x*2)
  def B(x: Int): Boolean = if(x == 0) true else false
  printSet(C)
  printSet(A)
  printSet(intersect(A,C))
}
