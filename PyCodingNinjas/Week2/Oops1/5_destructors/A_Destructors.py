class MyClass:
    def __init__(self):
        print("This is constructor")
    def __del__(self):
        print("This is destructor")
myobj=MyClass()
print("after creating myobj")
# This is constructor
# after creating myobj
# This is destructor# before the program ends or the objects work is done the destructor will be called
# Destructor is used to clean up the resources
