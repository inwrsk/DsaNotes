#we can access class methods with or without creating the object
class MyClass:
    x=10
    @classmethod
    def my_class_method(cls):
        print(cls.x)
        print(cls)
        print("This is class method")
    @staticmethod
    def my_static_method():
        #print(cls.x)#can't access class variable directly
        print("This is static method")
    def my_instance_method():
        print("This is instance method")

MyClass.my_class_method()#by default it passes the class name as the first argument so we need to mention in arg
#<class '__main__.MyClass'>
#This is class method
MyClass.my_static_method()#This is static method
MyClass.my_instance_method()#as MyClass won't pass self we needn't mention in declaration argument
#this is instance method

myobj=MyClass()
myobj.my_class_method()#myobj will pass class name
#<class '__main__.MyClass'>
#This is class method
myobj.my_static_method()#This is static method
#myobj.my_instance_method()#TypeError: my_instance_method() takes 0 positional arguments but 1 was given
#for instance method an object will pass self by default so we need to mention in declaration argument
class MyClass:
    def instanceMethod(self):
        print("This is instance method")
#MyClass.instanceMethod()#TypeError: instanceMethod() missing 1 required positional argument: 'self'
myobj=MyClass()
myobj.instanceMethod()#This is instance method