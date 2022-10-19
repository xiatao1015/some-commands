## git常见问题

>fatal: unable to access 'https://github.com/magnusja/ConvE.git/': Failed to connect to github.com port 443: Connection refused

solution:

+ git config --global url."https://ghproxy.com/https://github.com".insteadOf "https://github.com"