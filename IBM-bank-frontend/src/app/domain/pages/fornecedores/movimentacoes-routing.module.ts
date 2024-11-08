import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarMovimentacoesComponent } from './listar-Movimentacoes/listar-Movimentacoes.component';
import { FormMovimentacaoComponent } from './form-movimentacao/form-movimentacao.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: '',
        component: ListarMovimentacoesComponent
      },
      {
        path: 'novo',
        component: FormMovimentacaoComponent
      },
      {
        path: 'editar',
        component: FormMovimentacaoComponent
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MovimentacoesRoutingModule { }
