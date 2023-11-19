import java.util.Random;

public class LevyFlight {
    
    public static void main (String[] args){
        int sum_1=0;
        int sum_10=0;
        int sum_100=0;
        for (int i = 0; i < 1000; i++){
            double levyStep = 0;
            double beta = 1;
            double simga =  doSigma(beta);
            levyStep = getStep(simga, beta);
            System.out.println( i + " " + levyStep );
            if(levyStep<-100){
                sum_1++;
            }else if(levyStep<-10){
                sum_10++;
            }else{
                sum_100++;
            }
        }
        System.out.println(sum_1+" "+sum_10+" "+sum_100);
    
    }
    public static double getStep(double sigma, double beta){
        double u = new Random().nextGaussian()*sigma;
        double v = new Random().nextGaussian();
        return u/Math.pow(Math.abs(v), (1/beta));
    }
     
    
     public static double doSigma(double beta){
         double term1 = logGamma(beta+1)*Math.sin((Math.PI*beta)/2);
         double term2 = logGamma((beta+1)/2)*beta*Math.pow(2,(beta-1)/2);
         return Math.pow((term1/term2),(1/beta));
    }
     
     public static double logGamma(double x){
         double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
         double ser = 1.0 + 76.18009173    / (x + 0)   - 86.50532033    / (x + 1)
                        + 24.01409822    / (x + 2)   -  1.231739516   / (x + 3)
                        +  0.00120858003 / (x + 4)   -  0.00000536382 / (x + 5);
         return Math.exp(tmp + Math.log(ser * Math.sqrt(2 * Math.PI)));
    }

}