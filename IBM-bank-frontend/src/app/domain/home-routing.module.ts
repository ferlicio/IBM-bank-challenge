import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { TelaComponent } from './pages/tela/tela.component';

const routes: Routes = [
  {
    path: '',
    component: TelaComponent,
    children: [
      {
        path: '',
        redirectTo: 'clientes',
      },
      {
        path: 'clientes',
        loadChildren: () => import('./pages/clientes/clientes.module').then(m => m.ClientesModule)
      },
      {
        path: 'Movimentacoes',
        loadChildren: () => import('./pages/Movimentacoes/Movimentacoes.module').then(m => m.MovimentacoesModule)
      },
      /* {
        path: 'vendas',
        loadChildren: () => import('./home/home.module').then(m => m.HomeModule)
      }, */
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
