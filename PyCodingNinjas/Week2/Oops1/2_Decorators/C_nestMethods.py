def outerfun(a):
    def innerfun(b):
        if b==5:
            return b
        return a+b
    return innerfun
print(outerfun(5)(10))#15
#print(innerfun(5))#NameError: name 'innerfun' is not defined