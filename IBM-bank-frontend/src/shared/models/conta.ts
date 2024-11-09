export enum TipoConta {
    CORRENTE = 'CORRENTE',
    POUPANCA = 'POUPANCA'
}

export enum StatusConta {
    ATIVA = 'ATIVA',
    INATIVA = 'INATIVA'
}

export interface Conta {
    id: number;
    numero: number;
    tipoConta: TipoConta;
    saldo: number;
    status: StatusConta;
    clienteId: number;
}

export enum eColunaXPropConta {
    // 'Nome da coluna' = 'nome da propriedade'
    'ID' = 'id',
    'Número' = 'numero',
    'Tipo da Conta' = 'tipoConta',
    'Saldo' = 'saldo',
    'Status' = 'status',
    'ID do Cliente' = 'clienteId',
}