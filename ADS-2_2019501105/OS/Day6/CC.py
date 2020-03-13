import socket

def main():
    host = ''
    port = 5012

    s = socket.socket(socket.AF_INET, socket.SOCK_STEAM)
    s.connect((host, port))

    message = input("Enter message: ")
    while message != 'q':
    	s.send(str(message).encode('ASCII'))
    	data = s.recv(1024)
    	print("recieved from server: " + data.decode('ASCII'))
    	message = input("Enter another message: ")
    s.close()

if __name__=='__main__':
   	main()