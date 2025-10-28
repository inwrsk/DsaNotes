'''
a. The string begins with an 'a'
b. Each 'a' is followed by nothing or an 'a' or "bb"
c. Each "bb" is followed by nothing or an 'a'
'''
string='abbabbab'#false
if string[0]=='a':
    def checkAB(string):
        if len(string)==0:
            return 'true'
        if string[0]=='a':
                return checkAB(string[1:])
        if len(string)==1:
            return 'false'
        if len(string)>1:
            if  string[:2]=='bb':
                if len(string)>2:
                    if string[2]=='a':
                        return  checkAB(string[3:])
                    return 'false'
                return 'true'
            return 'false'
    print(checkAB(string[1:]))
else:print('false')