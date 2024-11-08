export enum StatusContaCredito {
    ATIVA = 'ATIVA',
    INATIVA = 'INATIVA'
}

export interface ContaCredito {
    id: number;
    contaId: number;
    limiteCredito: number;
    saldoUtilizado: number;
    dataFechamento: string;
    dataPagamento: string;
    status: StatusContaCredito;
}

export enum eColunaXPropContaCredito {
    // 'Nome da coluna' = 'nome da propriedade'
    'ID' = 'id',
    'ID da Conta' = 'contaId',
    'Limite de Crédito' = 'limiteCredito',
    'Saldo Utilizado' = 'saldoUtilizado',
    'Data de Fechamento' = 'dataFechamento',
    'Data de Pagamento' = 'dataPagamento',
    'Status' = 'status',
}