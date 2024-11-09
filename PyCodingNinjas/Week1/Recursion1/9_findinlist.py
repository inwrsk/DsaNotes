'''
check the first number if yes return found
if the len is 1 then no other option what we can do is send the result of first number
no there are another numbers:
then check for the new array leaving the number checked
'''
def checkNumber(arr, x):
    if len(arr)==1 or arr[0]==x:return arr[0]==x
    return checkNumber(arr[1:],x)
print(checkNumber([2,3,45,1,5,7,3],45))#Ture
print(checkNumber([2,3,'45',1,5,7,3],45))#False
##uses more space as we create new list every time