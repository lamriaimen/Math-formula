package formula;

public class Addition implements Formula {

    private VariableX vrx;
    private VariableX vrx2;

    private int m;
    private Constant Cnst;
    private Constant Cnst2;

     public Addition(Formula leftMember, Formula rightMember){
         if (leftMember.derivative().eval(2)==0) {
             if (rightMember.derivative().eval(2)==1) {
                 this.m = 1;
                 this.vrx = new VariableX();
                 this.Cnst = new Constant(leftMember.eval(1));

                 //CASE 1 leftFormulat is const and right is x

             } else  if (rightMember.derivative().eval(2)==0){
                 this.Cnst = new Constant(leftMember.eval(1));
                 this.Cnst2 = new Constant(rightMember.eval(1));

                 this.m = 2; //CASE 2 leftFormulat is const and right is also const
             }
         }
         else if(leftMember.derivative().eval(2)==1) {

             if (rightMember.derivative().eval(2)==1) {
                 this.vrx=new VariableX();
                 this.vrx2 = new VariableX();
                 this.m=3;//CASE 3 leftFormulat is x and right is also x


             }

         else if(rightMember.derivative().eval(2)==0){
                 this.m=4;
                 this.vrx=new VariableX();

             this.Cnst=new Constant(rightMember.eval(1));

                //CASE 4 leftFormulat is x and right is  const
             }

     }

     }

    public double eval(double xValue) {


        switch (this.m) {

            case 1:
            case 4:
                return xValue + this.Cnst.eval(xValue);
            case 2:
                return this.Cnst2.eval(xValue) + this.Cnst.eval(xValue);

            case 3:
                return xValue + xValue;


        }

        return 0;
    }


    public String toString(){

        switch (this.m) {

            case 1:return "("+ this.Cnst.toString()+"+"+this.vrx.toString()+")";
            case 4:
                return "("+this.vrx.toString()+"+"+this.Cnst.toString()+")";
            case 2:
                return "("+this.Cnst.toString() +"+"+ this.Cnst2.toString()+")"  ;

            case 3:
                return "("+this.vrx.toString()+"+"+this.vrx.toString()+")";


        }

        return "NULL";
    }








    @Override
    public Formula derivative() {
        switch (this.m) {

            case 1:
                return new Addition(this.Cnst.derivative(),this.vrx.derivative());
            case 4:
                return new Addition(this.vrx.derivative(),this.Cnst.derivative());
            case 2:
                return new Addition( this.Cnst.derivative(),this.Cnst2.derivative());

            case 3:
                return  new Addition(this.vrx.derivative(),this.vrx.derivative());


        }

        return null;

    }


}
