// environment ts é o mesmo prod ele é sobrescrito quando fizer a build de produção,
//então faz aqui para ser feito automaticamente la
export const environment = {
  production: false,
  apiURLBase: 'http://10.0.0.106:8080',
  clientId: 'my-angular-app',
  clientSecret: '@321',
  obterTokenUrl: '/oauth/token'
};

