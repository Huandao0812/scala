package forcomp
import Anagrams._
object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(127); 
	val ls = List("apple","oranges","nus","sun","leapp","daoduchuan","duchuandao");System.out.println("""ls  : List[String] = """ + $show(ls ));$skip(32); 
	val occ1 = wordOccurrences("");System.out.println("""occ1  : forcomp.Anagrams.Occurrences = """ + $show(occ1 ));$skip(36); 
  val occ2 = wordOccurrences("aac");System.out.println("""occ2  : forcomp.Anagrams.Occurrences = """ + $show(occ2 ));$skip(26); val res$0 = 
  sentenceOccurrences(ls);System.out.println("""res0: forcomp.Anagrams.Occurrences = """ + $show(res$0));$skip(26); val res$1 = 
  wordAnagrams("married");System.out.println("""res1: List[forcomp.Anagrams.Word] = """ + $show(res$1));$skip(539); 
  
  
 
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
  };System.out.println("""sentenceAnagrams2: (sentence: forcomp.Anagrams.Sentence)List[forcomp.Anagrams.Sentence]""")}
 


}
