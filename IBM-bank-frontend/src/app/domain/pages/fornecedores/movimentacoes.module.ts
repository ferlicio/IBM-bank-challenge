import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MovimentacoesRoutingModule } from './movimentacoes-routing.module';
import { FormMovimentacaoComponent } from './form-movimentacao/form-movimentacao.component';
import { ListarMovimentacoesComponent } from './listar-movimentacoes/listar-movimentacoes.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AitTableModule } from 'src/app/widget/ait-table/ait-table.module';
import { MaterialModule } from 'src/app/material/material.module';
import { AitFormModule } from 'src/app/widget/ait-form/ait-form.module';


@NgModule({
  declarations: [
    FormMovimentacaoComponent,
    ListarMovimentacoesComponent
  ],
  imports: [
    CommonModule,
    MovimentacoesRoutingModule,
    MaterialModule,
    ReactiveFormsModule,
    AitTableModule,
    AitFormModule,
  ]
})
export class MovimentacoesModule { }
