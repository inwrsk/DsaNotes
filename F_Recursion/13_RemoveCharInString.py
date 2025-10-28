# Problem: Remove x from string
'''
get the result from side array
check our current char
and merge those two results
'''
def removeX(string): 
    if len(string)==0:
        return ''
    minires=removeX(string[1:])
    if string[0] in ['x','X']:
        return ''+minires
    return string[0]+minires
print(removeX('extra'))#etra