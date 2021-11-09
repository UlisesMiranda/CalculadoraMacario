package Calculadora;

public class Calculadora 
{
        private double memoria=0;
	private char operadorAnterior='=';
        private boolean radianes=true;


	public void operacion(double numero, char operador)
	{
            
            if(operadorAnterior=='=')
                memoria = numero;
            else
            	switch(operadorAnterior)
		{
                    case '+': memoria+=numero; break;
                    case '-': memoria-=numero; break;
		}
            operadorAnterior=operador;
	}

        public void clearMemory()
        {
            memoria=0;
        }
        
	public double getMemoria()
	{
		return memoria;
	}

        public void setRadianes()
        {
            radianes=false;
        }
        
        public void setDegrees()
        {
            radianes=false;
        }
        
        public boolean isRadianes()
        {
            return radianes;
        }
}
