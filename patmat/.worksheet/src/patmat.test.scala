package patmat
import Huffman._
object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(88); 
  def ls = List(2,2,3,3,1,2,2,5,7,4,4,5,7);System.out.println("""ls: => List[Int]""");$skip(37); 
	def vs = "aaaaaaaabbbcdefgh".toList;System.out.println("""vs: => List[Char]""");$skip(29); 
 	val lf = Huffman.times(vs);System.out.println("""lf  : List[(Char, Int)] = """ + $show(lf ));$skip(49); 
  val leafList = Huffman.makeOrderedLeafList(lf);System.out.println("""leafList  : List[patmat.Huffman.Leaf] = """ + $show(leafList ));$skip(102); 
  val testl = List(Huffman.Leaf('e',3),Huffman.Leaf('t',4), Huffman.Leaf('x',5),Huffman.Leaf('d',10));System.out.println("""testl  : List[patmat.Huffman.Leaf] = """ + $show(testl ));$skip(37); 
  val test1 = Huffman.combine(testl);System.out.println("""test1  : List[patmat.Huffman.CodeTree] = """ + $show(test1 ));$skip(37); 
  val test2 = Huffman.combine(test1);System.out.println("""test2  : List[patmat.Huffman.CodeTree] = """ + $show(test2 ));$skip(42); 
  val test3 = Huffman.combine(test2).head;System.out.println("""test3  : patmat.Huffman.CodeTree = """ + $show(test3 ));$skip(41); 
  val a ="eeettttxxxxxdddddddddd".toList;System.out.println("""a  : List[Char] = """ + $show(a ));$skip(39); 
  val test4= Huffman.createCodeTree(a);System.out.println("""test4  : patmat.Huffman.CodeTree = """ + $show(test4 ));$skip(17); val res$0 = 
  test3 == test4;System.out.println("""res0: Boolean = """ + $show(res$0));$skip(70); val res$1 = 
  
  Huffman.until(Huffman.singleton, Huffman.combine)(leafList).head;System.out.println("""res1: patmat.Huffman.CodeTree = """ + $show(res$1));$skip(46); 
  
  val codetree= Huffman.createCodeTree(vs);System.out.println("""codetree  : patmat.Huffman.CodeTree = """ + $show(codetree ));$skip(49); val res$2 = 
  Huffman.decode(codetree,List(1,0,0,0,1,0,1,0));System.out.println("""res2: List[Char] = """ + $show(res$2));$skip(94); 
  def sumF(f: Int=> Int, a: Int, b:Int): Int=
  	if (a > b) 0
  	else f(a) + sumF(f,a + 1, b);System.out.println("""sumF: (f: Int => Int, a: Int, b: Int)Int""");$skip(20); val res$3 = 
  	sumF(x=> x, 1,5);System.out.println("""res3: Int = """ + $show(res$3));$skip(21); val res$4 = 
	
	convert(codetree);System.out.println("""res4: patmat.Huffman.CodeTable = """ + $show(res$4));$skip(60); 
  val quickencoded = quickEncode(frenchCode)(decodedSecret);System.out.println("""quickencoded  : List[patmat.Huffman.Bit] = """ + $show(quickencoded ));$skip(25); val res$5 = 
  quickencoded == secret;System.out.println("""res5: Boolean = """ + $show(res$5))}
}
