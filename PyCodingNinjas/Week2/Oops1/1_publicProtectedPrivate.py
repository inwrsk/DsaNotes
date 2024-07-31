class myClass:
    def __init__(self,v1,v2,v3):
        self.var1=v1
        self._var2=v2
        self.__var3=v3
myObj=myClass('public','protected','private')
print(myObj.__dict__)#{'var1': 'public', '_var2': 'protected', '_myClass__var3': 'private'}

print(myObj.var1,myObj._var2)#public protected
myObj.var1='public1'
myObj._var2='protected1'
print(myObj.var1,myObj._var2)#public1 protected1

#print(myObj.__var3)#attributeError
print(myObj._myClass__var3)#private
myObj._myClass__var3='private1'
print(myObj._myClass__var3)
#these naming conventions are just to denote how to use them
#these are not strict