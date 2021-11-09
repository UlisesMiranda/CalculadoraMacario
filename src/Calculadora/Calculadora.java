package Calculadora;

public class Calculadora {
    
    private int operadorAnterior = 0;
    private double ANS = 0;
    private boolean radianes=true;
    
    public void operacion(double numero, int operador, boolean Radianes)
    {
        if(operadorAnterior == 0) // Si es igual a '='
                ANS = numero;
        else 
            switch(operadorAnterior)
            {
                case 1 : ANS += numero; break;
                case 2 : ANS -= numero; break;
                case 3 : ANS *= numero; break;
                case 4 : ANS /= numero; break;
                case 5 : ANS = inverso(); break;
                case 6 : ANS = cuadrado(); break;
                case 7 : ANS = raizCuadrada(); break;
                case 8 : ANS = raizCubica(); break;
                case 9 : 
                    if (Radianes == isRadianes())
                        ANS = seno();
                    else {
                        ANS = Math.toRadians(ANS);
                        ANS = seno();             
                    }
                    break;
                case 10 : 
                    if (Radianes == isRadianes())
                        ANS = coseno();
                    else {
                        ANS = Math.toRadians(ANS);
                        ANS = coseno();
                    }
                    break;
                case 11 : 
                    if (Radianes == isRadianes())
                        ANS = tangente();
                    else {
                        ANS = Math.toRadians(ANS);
                        ANS = tangente();
                    }
                    break;
            }
        operadorAnterior=operador;
  
    }
    
    public void clearANS()
    {
        this.ANS=0;
    }

    public double getANS()
    {
        return this.ANS;
    }

    public void setRadianes()
    {
        this.radianes=false;
    }

    public double setDegrees(double conversion)
    {
        return  Math.toDegrees(conversion);
    }

    public boolean isRadianes()
    {
        return this.radianes;
    }
    
    public double seno()
    {
        return (Math.sin(this.ANS));
    }
   
    public double coseno()
    {
        return (Math.cos(this.ANS));
    }
    
    public double tangente()
    {
         return (Math.tan(this.ANS));
    }
    
    public double cuadrado()
    {
        return (Math.pow(this.ANS, 2));
    }
    
    public double inverso()
    {
        return (Math.pow(this.ANS, -1));
    }
    
    public double raizCuadrada()
    {
        return (Math.sqrt(this.ANS));
    }
    
    public double raizCubica()
    {
        return (Math.cbrt(this.ANS));
    }
}
