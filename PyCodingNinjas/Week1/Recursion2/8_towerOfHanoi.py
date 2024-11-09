'''
first move the all the disks above the bottom one to aux(n-1)
and move bottom one to destination
move all the n-1 disks to destination
'''
def towerofhanoi(n, source, aux, dest):
    if n:
        towerofhanoi(n-1,source,dest,aux)
        print(source,dest)
        towerofhanoi(n-1,aux,source,dest)

n=3
towerofhanoi(n, 'a', 'b', 'c')
'''
a c
a b
c b
a c
b a
b c
a c
'''