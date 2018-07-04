package watsonTest.watsonTest;
import java.util.*;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifiedClass;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifyOptions;



import twitter.twitter.testTwitter;
import account.*;

public class TwitterKeywordAnalysis {
	public static member keywordAnalysis(member twitter,String text)
	{
		if(text.equals(null) || text.equals(""))
		{
			System.out.println("This twitter has no post article already 7 days.");
			twitter.clearKeyword();
		}
		else
		{
			//呼叫API分析文章
			NaturalLanguageClassifier service = new NaturalLanguageClassifier();
		    service.setUsernameAndPassword("79d4aacc-bfe4-4aa8-8cfd-1e8d1f18c13e", "mlFQ65Fvp1Y0");
		    
		    ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
		        .classifierId("20789cx471-nlc-57")
		        .text(text)
		        .build();
		    Classification classification = service.classify(classifyOptions).execute();
		    
		    
		    
		    
		    //判斷是否該分類為關鍵字( 可靠度大於 0.8 )
		    ArrayList<ClassifiedClass> result = (ArrayList<ClassifiedClass>) classification.getClasses();
		    //清除用戶原本的關鍵字(重新更新)
		    twitter.clearKeyword();
		    
		    
		    
		    for(ClassifiedClass tmp:result)
		    {
		    	if(tmp.getConfidence()>0.1)
		    	{
		    		twitter.addKeyword(tmp.getClassName());
		    		
		    	}
		    	System.out.println(tmp);
		    }
		}
		
		return twitter;
		
		
		
		
	}

	
	///執行測試範例
	public static void main(String[] args) {
		String twitterText="I like java!!";	//twitter文章
		member twitter;	//帳戶
		
		twitter=new member("harry","00457039","123456");
		
		twitterText=testTwitter.TwitterAPI(twitter);
		
		
		//分析並回傳更新好的member
		twitter=TwitterKeywordAnalysis.keywordAnalysis(twitter, twitterText);
		
		
	}
}
