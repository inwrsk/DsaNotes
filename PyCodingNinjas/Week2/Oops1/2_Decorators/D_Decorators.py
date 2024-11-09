import inspect

def fun(f):
    def inner(n):
        return f(n)*n
    return inner

@fun#now the cube is fun(cube) i.e inner
def cube(n):
    return n*n

print(inspect.getsource(cube))
    # def inner(n):
    #     return f(n)*n

print(cube(3))#27