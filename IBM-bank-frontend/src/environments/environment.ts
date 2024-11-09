const appName = 'IBM Bank';

export const environment = {

    production: false,
    appName: appName,
    pagesTitle: {
        '/': appName +' | Página Inicial',

        '/clientes/novo': appName +' | Novo cliente',
        '/clientes/editar': appName +' | Editar cliente',

        '/movimentacoes': appName +' | Movimentações',
        '/movimentacoes/novo': appName +' | Nova movimentação',

    } as {[key: string]: string},
    IBMBankApi: {
        baseUrl: 'http://localhost:3000',
        endpoints: {
            clientes: '/clientes',
            movimentacoes: '/movimentacoes',
            contas: '/contas',
            contasCredito: '/contasCredito',
        }
    },

}

export const baseEnvironment = environment;
