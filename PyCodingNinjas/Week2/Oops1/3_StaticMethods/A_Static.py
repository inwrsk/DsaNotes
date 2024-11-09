#by using static methods we can access the class methods with or without creating the object
class Calculator:
    x=10
    def add(a,b):
        #print(x)#NameError: name 'x' is not defined
        return a+b
    @staticmethod
    def sub(a,b):
        #print(x)#NameError: name 'x' is not defined
        return a-b
print(Calculator.add(4,5))#9 (class can't pass the self by default)
print(Calculator.sub(4,5))#-1 
myCal=Calculator() 
# print(myCal.add(4,5))#self is passed by default so the error add() takes 2 positional arguments but 3 were given
print(myCal.sub(4,5))#-1 (as it is static method self is not passed by default)