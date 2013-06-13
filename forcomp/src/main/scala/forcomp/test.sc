package forcomp
import Anagrams._
object test {
	val ls = List("apple","oranges","nus","sun","leapp","daoduchuan","duchuandao")
                                                  //> ls  : List[String] = List(apple, oranges, nus, sun, leapp, daoduchuan, duchu
                                                  //| andao)
	val occ1 = wordOccurrences("")            //> occ1  : forcomp.Anagrams.Occurrences = List()
  val occ2 = wordOccurrences("aac")               //> occ2  : forcomp.Anagrams.Occurrences = List((a,2), (c,1))
  sentenceOccurrences(ls)                         //> res0: forcomp.Anagrams.Occurrences = List((a,7), (c,2), (d,4), (e,3), (g,1),
                                                  //|  (h,2), (l,2), (n,5), (o,3), (p,4), (r,1), (s,3), (u,6))
  wordAnagrams("married")                         //> res1: List[forcomp.Anagrams.Word] = List(admirer, married)
  
  
 
  def sentenceAnagrams2(sentence: Sentence): List[Sentence]= {
    val occ = sentenceOccurrences(sentence)
    
    //helper function for sentenceAnagram
    //Produce a lsit of Occurrences
    //from occ with the first element
    def subAnagrams(occ: Occurrences): List[Sentence] =	{
    	if (occ == Nil)
    		List(List())
    	else
    		for{
    		x <- combinations(occ)
    		if(x !=Nil)
    		y <- subAnagrams(subtract(occ,x))
    		z <- dictionaryByOccurrences(x)
    		} yield(z :: y)
    	
    }
   	subAnagrams(occ)
  }                                               //> sentenceAnagrams2: (sentence: forcomp.Anagrams.Sentence)List[forcomp.Anagram
                                                  //| s.Sentence]
 


}