"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
var Person = /** @class */ (function () {
    function Person(firstName, lastName, age, ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ssn = ssn;
    }
    Person.prototype.mostrar = function (firstName, lastName) {
        return p.firstName + "-" + p.lastName;
    };
    return Person;
}());
exports.Person = Person;
var Employee = /** @class */ (function (_super) {
    __extends(Employee, _super);
    function Employee(firstName, lastName, age, ssn, cargo) {
        var _this = _super.call(this, firstName, lastName, age, ssn) || this;
        _this.cargo = cargo;
        return _this;
    }
    Employee.prototype.puedeTrabajar = function (age) {
        if (age > 18 && age < 65) {
            return true;
        }
        else {
            return false;
        }
    };
    return Employee;
}(Person));
function getStock() {
    symbol: "IBM";
}
var p = new Person("John", "smith", 29, "123-90");
p.firstName = "John";
p.lastName = "smith";
p.age = 29;
p.ssn = "123-90";
var e = new Employee("John", "smith", 29, "123-90", "jefe");
