'''@author Madhuri'''

import socket

def main():
    host = 'localhost'
    port = 8818
    server = ('localhost', 8888)
    soc = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    soc.bind((host, port))
    message = input("Client Input: ")

    while message != '.':
        soc.sendto(message.encode(), server)
        data, addr = soc.recvfrom(1024)
        print('Recieved from server as: ' + str(data.decode()))
        message = input("Client Input: ")
    soc.close()

if __name__=='__main__':
    main()
    