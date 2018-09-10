Simple notification service that fetches cryptocurrency prices and sends a slack notification


#Encrypt props

The project uses Jasypt to encrypt properties. This is optional, you can
use properties without encryption if you want

However, follow the steps to use encrypted props

- Download jasypt from `http://www.jasypt.org/download.html`
- Afgter unzipping, navigate to `/bin`
- Run `sh encrypt.sh input="<string_to_encode>" password="<your_password>" `
- Add the output to the relevant property in `application.properties` as `ENC(<output>)`
- Add `jasypt.encryptor.password` as an env variable with the same password used earlier
- Run Spring boot app
