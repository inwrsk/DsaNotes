'''
if there is one element obviously return sorted
else compare the first and second element and check for the array from second element
'''
def func(lst):
    if len(lst)==1:
        return True
    if lst[0]>lst[1]:
        return False
    return func(lst[1:])
print(func([1,2,30,4.2,5]))#False
print(func([1,5,67,90]))#True
#uses more space as we create new list every time