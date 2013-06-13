package patmat
import Huffman._
object test {
  def ls = List(2,2,3,3,1,2,2,5,7,4,4,5,7)        //> ls: => List[Int]
	def vs = "aaaaaaaabbbcdefgh".toList       //> vs: => List[Char]
 	val lf = Huffman.times(vs)                //> lf  : List[(Char, Int)] = List((a,8), (b,3), (c,1), (d,1), (e,1), (f,1), (g,
                                                  //| 1), (h,1))
  val leafList = Huffman.makeOrderedLeafList(lf)  //> leafList  : List[patmat.Huffman.Leaf] = List(Leaf(c,1), Leaf(d,1), Leaf(e,1)
                                                  //| , Leaf(f,1), Leaf(g,1), Leaf(h,1), Leaf(b,3), Leaf(a,8))
  val testl = List(Huffman.Leaf('e',3),Huffman.Leaf('t',4), Huffman.Leaf('x',5),Huffman.Leaf('d',10))
                                                  //> testl  : List[patmat.Huffman.Leaf] = List(Leaf(e,3), Leaf(t,4), Leaf(x,5), L
                                                  //| eaf(d,10))
  val test1 = Huffman.combine(testl)              //> test1  : List[patmat.Huffman.CodeTree] = List(Leaf(x,5), Fork(Leaf(e,3),Leaf
                                                  //| (t,4),List(e, t),7), Leaf(d,10))
  val test2 = Huffman.combine(test1)              //> test2  : List[patmat.Huffman.CodeTree] = List(Leaf(d,10), Fork(Leaf(x,5),For
                                                  //| k(Leaf(e,3),Leaf(t,4),List(e, t),7),List(x, e, t),12))
  val test3 = Huffman.combine(test2).head         //> test3  : patmat.Huffman.CodeTree = Fork(Leaf(d,10),Fork(Leaf(x,5),Fork(Leaf(
                                                  //| e,3),Leaf(t,4),List(e, t),7),List(x, e, t),12),List(d, x, e, t),22)
  val a ="eeettttxxxxxdddddddddd".toList          //> a  : List[Char] = List(e, e, e, t, t, t, t, x, x, x, x, x, d, d, d, d, d, d,
                                                  //|  d, d, d, d)
  val test4= Huffman.createCodeTree(a)            //> test4  : patmat.Huffman.CodeTree = Fork(Leaf(d,10),Fork(Leaf(x,5),Fork(Leaf(
                                                  //| e,3),Leaf(t,4),List(e, t),7),List(x, e, t),12),List(d, x, e, t),22)
  test3 == test4                                  //> res0: Boolean = true
  
  Huffman.until(Huffman.singleton, Huffman.combine)(leafList).head
                                                  //> res1: patmat.Huffman.CodeTree = Fork(Leaf(a,8),Fork(Fork(Fork(Leaf(g,1),Leaf
                                                  //| (h,1),List(g, h),2),Fork(Leaf(e,1),Leaf(f,1),List(e, f),2),List(g, h, e, f),
                                                  //| 4),Fork(Fork(Leaf(c,1),Leaf(d,1),List(c, d),2),Leaf(b,3),List(c, d, b),5),Li
                                                  //| st(g, h, e, f, c, d, b),9),List(a, g, h, e, f, c, d, b),17)
  
  val codetree= Huffman.createCodeTree(vs)        //> codetree  : patmat.Huffman.CodeTree = Fork(Leaf(a,8),Fork(Fork(Fork(Leaf(g,1
                                                  //| ),Leaf(h,1),List(g, h),2),Fork(Leaf(e,1),Leaf(f,1),List(e, f),2),List(g, h, 
                                                  //| e, f),4),Fork(Fork(Leaf(c,1),Leaf(d,1),List(c, d),2),Leaf(b,3),List(c, d, b)
                                                  //| ,5),List(g, h, e, f, c, d, b),9),List(a, g, h, e, f, c, d, b),17)
  Huffman.decode(codetree,List(1,0,0,0,1,0,1,0))  //> res2: List[Char] = List(g, e)
  def sumF(f: Int=> Int, a: Int, b:Int): Int=
  	if (a > b) 0
  	else f(a) + sumF(f,a + 1, b)              //> sumF: (f: Int => Int, a: Int, b: Int)Int
  	sumF(x=> x, 1,5)                          //> res3: Int = 15
	
	convert(codetree)                         //> res4: patmat.Huffman.CodeTable = List((a,List(0)), (g,List(1, 0, 0, 0)), (h,
                                                  //| List(1, 0, 0, 1)), (e,List(1, 0, 1, 0)), (f,List(1, 0, 1, 1)), (c,List(1, 1,
                                                  //|  0, 0)), (d,List(1, 1, 0, 1)), (b,List(1, 1, 1)))
  val quickencoded = quickEncode(frenchCode)(decodedSecret)
                                                  //> quickencoded  : List[patmat.Huffman.Bit] = List(0, 0, 1, 1, 1, 0, 1, 0, 1, 1
                                                  //| , 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1,
                                                  //|  0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 
                                                  //| 1, 0, 1)
  quickencoded == secret                          //> res5: Boolean = true
}