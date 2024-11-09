export interface Cliente {
  id?:number, 
  nome: string, 
  idade: number,
  endereco: string,
  email: string, 
  numeroConta?: number,
}

export enum eColunaXPropCliente {
  // 'Nome da coluna' = 'nome da propriedade'
  'id' = 'id', 
  'Tipo' = 'tipo',
  'Nome' = 'nome', 
  'Idade' = 'idade',
  'Endereço' = 'endereco',
  'Email' = 'email', 
  'Número da conta' = 'numeroConta',
}