'''
if no of times to be repeated is 0 then return 1
else:
multiply num and func(no of times repated - 1)
'''
def cal(y):
    if y==0:
        return 1
    return x*cal(y-1)
x,y=3,4
print(cal(y))#81