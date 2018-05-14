export class  Person{
    firstName: string;
    lastName: string;
    age: number;
    ssn: string;

   
public constructor( firstName: string,  lastName:string,  age:number,  ssn:string){
this.firstName=firstName;
this.lastName=lastName;
this.age=age;
this.ssn=ssn;
}



mostrar(firstName:string,lastName:string) {
    return p.firstName+ "-"+p.lastName;
}
}
class Employee extends Person implements Cotizable{
    cargo: string;
    public constructor(firstName: string,  lastName:string,  age:number,  ssn:string,cargo:string){
        super(firstName,lastName,age,ssn);
        this.cargo=cargo;
    }
    puedeTrabajar(age:number): boolean{
    if(age > 18 && age < 65){
        return true;    

    }else{
        return false;
    }
}

}
interface Cotizable{
    puedeTrabajar(age: number): boolean;
      
        
    }
    function getStock(){
    symbol:"IBM";

    }



var p = new Person("John","smith",29,"123-90");

p.firstName="John";
p.lastName="smith";
p.age=29;
p.ssn="123-90";

var e= new Employee("John","smith",29,"123-90","jefe");


