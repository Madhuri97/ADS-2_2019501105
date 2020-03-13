'''@author Madhuri'''

import socket

def main():
    host = '127.0.0.1'
    port = 4506
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM) 
    s.bind((host, port))
    s.listen(5)
    message, addr = s.accept()
    print("Connection from: "+str(addr))

    while True:
        data = message.recv(1024).decode('ASCII')
        if not data:
            break
        print("From connected user: " + str(data))
        data = str(data).upper()
        print("sending: " + str(data))
        message.send(str(data).encode('ASCII'))

    message.close()

if __name__=='__main__':
    main()
    