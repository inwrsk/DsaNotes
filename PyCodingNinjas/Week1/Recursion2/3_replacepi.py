#to replce pi with 3.14 in the string
'''
check whether the given string contains atleast 2 chars 
no?return the string
yes?
    check the first two chars is 'pi'
    no?
        return first char+func(string from second char) eg:ppi
    yes?
        return '3.14'+func(string from thrid char)
'''
def replace(string):
    if len(string)==0 or len(string)==1:
        return string
    if string[:2]=='pi':
        return '3.14'+replace(string[2:])
    return string[0]+replace(string[1:])
print(replace('ppihellopipip'))#p3.14hello3.143.14p