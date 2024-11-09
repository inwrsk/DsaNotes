class MyClass:
    def __init__(self):
        print("This is constructor")
    def __del__(self):
        print("This is destructor")
        
def myfunc():
    myobj=MyClass()
    print("after creating myobj")

print("before calling myfunc")
myfunc()#as the functions work completed the destructor is called
print("after calling myfunc")
# before calling myfunc
# This is constructor
# after creating myobj
# This is destructor
# after calling myfunc
print()
def myfunc2():
    myobj=MyClass()
    return myobj
print("before calling myfunc2")
myfunc2()
print("after calling myfunc2")
# before calling myfunc2
# This is constructor
# after creating myobj
# This is destructor
# after calling myfunc2
print()
def myfunc3():
    myobj=MyClass()
    return myobj
print("before calling myfunc3")
x=myfunc3()
x=3#destroying the object
print("after calling myfunc3")
# before calling myfunc3
# This is constructor
# This is destructor
# after calling myfunc3
print()
def myfunc4():
    myobj=MyClass()
    return myobj
print("before calling myfunc4")
y=myfunc4()#will destroy object after it is dereferenced
print("after calling myfunc4")
# before calling myfunc4
# This is constructor
# after calling myfunc4

print()
myobj=MyClass()
del myobj
# This is constructor
# This is destructor
# This is destructor (from y near myfunc4())